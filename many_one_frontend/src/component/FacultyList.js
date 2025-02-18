import React, { useState, useEffect } from "react";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js"; // ✅ Ensure Bootstrap JS is included
import "bootstrap-icons/font/bootstrap-icons.css";
import BASE_URL from "./../api/bootapi";

const FacultyList = () => {
  const [faculties, setFaculties] = useState([]);
  const [selectedFaculty, setSelectedFaculty] = useState({ fid: "", facultyname: "", designition: "", department: {} });
  const [showModal, setShowModal] = useState(false); // ✅ Controls modal visibility

  useEffect(() => {
    fetchFaculties();
  }, []);

  // Fetch Faculty List
  const fetchFaculties = () => {
    axios
      .get(`${BASE_URL}/faculty/displayfaculty`)
      .then((response) => {
        if (Array.isArray(response.data)) {
          setFaculties(response.data);
        } else {
          toast.error("Invalid faculty data format!");
        }
      })
      .catch(() => {
        toast.error("Error fetching faculties!");
      });
  };

  // Open the update modal
  const handleUpdateClick = (faculty) => {
    setSelectedFaculty(faculty);
    setShowModal(true);
  };

  // Handle input change (only allow changes to facultyname & designition)
  const handleChange = (e) => {
    const { name, value } = e.target;
    setSelectedFaculty((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // Handle update submission
  const handleUpdate = () => {
    axios
      .put(`${BASE_URL}/faculty/updatefaculty/${selectedFaculty.fid}`, {
        facultyname: selectedFaculty.facultyname,
        designition: selectedFaculty.designition,
      })
      .then(() => {
        toast.success("Faculty updated successfully!");
        setFaculties((prev) =>
          prev.map((fac) => (fac.fid === selectedFaculty.fid ? { ...fac, ...selectedFaculty } : fac))
        );
        setShowModal(false);
      })
      .catch(() => {
        toast.error("Error updating faculty!");
      });
  };

  // Handle faculty deletion
  const handleDelete = (fid) => {
    axios
      .delete(`${BASE_URL}/faculty/deletefaculty/${fid}`)
      .then(() => {
        toast.success("Faculty deleted successfully!");
        setFaculties((prev) => prev.filter((faculty) => faculty.fid !== fid));
      })
      .catch(() => {
        toast.error("Error deleting faculty!");
      });
  };

  return (
    <div className="container mt-4">
      <ToastContainer />
      <h2 className="text-center mb-4">Faculty List</h2>
      <div className="table-responsive">
        <table className="table table-striped table-hover table-bordered">
          <thead className="table-dark">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Designation</th>
              <th>Department</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {faculties.length === 0 ? (
              <tr>
                <td colSpan="5" className="text-center">No faculty available</td>
              </tr>
            ) : (
              faculties.map((faculty) => (
                <tr key={faculty.fid}>
                  <td>{faculty.fid}</td>
                  <td>{faculty.facultyname}</td>
                  <td>{faculty.designition || "N/A"}</td>
                  <td>{faculty.department?.dname || "N/A"}</td>
                  <td>
                    <button
                      className="btn btn-warning btn-sm me-2"
                      onClick={() => handleUpdateClick(faculty)}
                    >
                      <i className="bi bi-pencil-square"></i> Update
                    </button>
                    <button
                      className="btn btn-danger btn-sm"
                      onClick={() => handleDelete(faculty.fid)}
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
                  <h5 className="modal-title">Update Faculty</h5>
                  <button type="button" className="btn-close" onClick={() => setShowModal(false)}></button>
                </div>
                <div className="modal-body">
                  <div className="mb-3">
                    <label className="form-label">Faculty ID</label>
                    <input
                      type="text"
                      className="form-control"
                      name="fid"
                      value={selectedFaculty.fid}
                      readOnly
                    />
                  </div>
                  <div className="mb-3">
                    <label className="form-label">Faculty Name</label>
                    <input
                      type="text"
                      className="form-control"
                      name="facultyname"
                      value={selectedFaculty.facultyname}
                      onChange={handleChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label className="form-label">Designation</label>
                    <input
                      type="text"
                      className="form-control"
                      name="designition"
                      value={selectedFaculty.designition}
                      onChange={handleChange}
                    />
                  </div>
                  <div className="mb-3">
                    <label className="form-label">Department</label>
                    <input
                      type="text"
                      className="form-control"
                      value={selectedFaculty.department?.dname || "N/A"}
                      readOnly
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

export default FacultyList;