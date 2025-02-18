import React, { useEffect, useState } from "react";
import axios from "axios";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import BASE_URL from "./../api/bootapi";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js"; 
import "bootstrap-icons/font/bootstrap-icons.css";

const DepartmentList = () => {
  const [departments, setDepartments] = useState([]);
  const [selectedDepartment, setSelectedDepartment] = useState({ did: "", dname: "" });
  const [showModal, setShowModal] = useState(false); 

  // Fetch departments from API
  useEffect(() => {
    axios
      .get(`${BASE_URL}/department/displaydepart`)
      .then((response) => {
        if (Array.isArray(response.data)) {
          setDepartments(response.data);
        } else {
          toast.error("Invalid data format from server!");
        }
      })
      .catch(() => {
        toast.error("Error fetching department data!");
      });
  }, []);

  // Open the update modal
  const handleUpdateClick = (department) => {
    setSelectedDepartment(department);
    setShowModal(true);
  };

  // Handle input change
  const handleChange = (e) => {
    const { name, value } = e.target;
    setSelectedDepartment((prev) => ({ ...prev, [name]: value }));
  };

  // Handle update submission
  const handleUpdate = () => {
    axios
      .put(`${BASE_URL}/department/updatedepart/${selectedDepartment.did}`, selectedDepartment)
      .then(() => {
        toast.success("Department updated successfully!");
        setDepartments((prev) =>
          prev.map((dept) => (dept.did === selectedDepartment.did ? selectedDepartment : dept))
        );
        setShowModal(false);
      })
      .catch(() => {
        toast.error("Error updating department!");
      });
  };

  // Handle delete
  const handleDelete = (id) => {
    axios
      .delete(`${BASE_URL}/department/deletedepart/${id}`)
      .then(() => {
        toast.success("Department deleted successfully!");
        setDepartments((prev) => prev.filter((department) => department.did !== id));
      })
      .catch(() => {
        toast.error("Error deleting department!");
      });
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">Department List</h2>

      <div className="table-responsive">
        <table className="table table-striped table-hover table-bordered">
          <thead className="table-dark text-center">
            <tr>
              <th>#</th>
              <th>Department Name</th>
              <th>Department ID</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {departments.length === 0 ? (
              <tr>
                <td colSpan="4" className="text-center text-muted">
                  No departments available
                </td>
              </tr>
            ) : (
              departments.map((department, index) => (
                <tr key={department.did}>
                  <td className="text-center fw-bold">{index + 1}</td>
                  <td className="text-center">{department.dname}</td>
                  <td className="text-center">{department.did}</td>
                  <td className="text-center">
                    <button
                      className="btn btn-warning btn-sm me-2"
                      onClick={() => handleUpdateClick(department)}
                    >
                      <i className="bi bi-pencil-square"></i> Update
                    </button>
                    <button
                      className="btn btn-danger btn-sm"
                      onClick={() => handleDelete(department.did)}
                    >
                      <i className="bi bi-trash"></i> Delete
                    </button>
                  </td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      </div>

      {/* Update Modal */}
      {showModal && (
        <>
          <div className="modal fade show d-block" tabIndex="-1" role="dialog">
            <div className="modal-dialog">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Update Department</h5>
                  <button type="button" className="btn-close" onClick={() => setShowModal(false)}></button>
                </div>
                <div className="modal-body">
                  <div className="mb-3">
                    <label className="form-label">Department ID</label>
                    <input
                      type="text"
                      className="form-control"
                      name="did"
                      value={selectedDepartment.did}
                      readOnly // Prevent ID change
                    />
                  </div>
                  <div className="mb-3">
                    <label className="form-label">Department Name</label>
                    <input
                      type="text"
                      className="form-control"
                      name="dname"
                      value={selectedDepartment.dname}
                      onChange={handleChange}
                    />
                  </div>
                </div>
                <div className="modal-footer">
                  <button type="button" className="btn btn-secondary" onClick={() => setShowModal(false)}>
                    Close
                  </button>
                  <button type="button" className="btn btn-success" onClick={handleUpdate}>
                    Save Changes
                  </button>
                </div>
              </div>
            </div>
          </div>
          {/* Background overlay for modal */}
          <div className="modal-backdrop fade show"></div>
        </>
      )}
    </div>
  );
};

export default DepartmentList;