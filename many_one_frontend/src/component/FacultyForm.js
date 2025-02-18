import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { toast, ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import BASE_URL from "./../api/bootapi";

const FacultyForm = () => {
  const [faculty, setFaculty] = useState({ fid: "", facultyname: "", designition: "", did: "" });
  const [departments, setDepartments] = useState([]);
  const navigate = useNavigate();

  // Fetch departments from API
  useEffect(() => {
    axios
      .get(`${BASE_URL}/department/displaydepart`)
      .then((response) => {
        if (Array.isArray(response.data)) {
          setDepartments(response.data);
        } else {
          toast.error("Invalid department data format!");
        }
      })
      .catch(() => {
        toast.error("Failed to fetch departments!");
      });
  }, []);

  // Handle input changes
  const handleChange = (e) => {
    setFaculty({ ...faculty, [e.target.name]: e.target.value });
  };

  // Handle department selection
  const handleDepartmentChange = (e) => {
    setFaculty({ ...faculty, did: Number(e.target.value) });
  };

  // Handle form submission (No Navigation)
  const handleSubmit = (e) => {
    e.preventDefault();
    if (!faculty.fid || !faculty.facultyname || !faculty.designition || !faculty.did) {
      toast.error("All fields are required!");
      return;
    }

    const facultyData = {
      fid: faculty.fid,
      facultyname: faculty.facultyname,
      designition: faculty.designition,
      department: { did: faculty.did },
    };

    axios
      .post(`${BASE_URL}/faculty/addfaculty`, facultyData)
      .then(() => {
        toast.success("Faculty added successfully!");
        setFaculty({ fid: "", facultyname: "", designition: "", did: "" }); // Clear form after successful submission
      })
      .catch(() => {
        toast.error("Error adding faculty!");
      });
  };

  return (
    <div className="container mt-4">
      <ToastContainer position="top-right" autoClose={3000} />
      <h2 className="text-center">Add Faculty</h2>
      <form onSubmit={handleSubmit} className="p-4 border rounded bg-light">
        <div className="mb-3">
          <label className="form-label">Faculty ID</label>
          <input type="text" className="form-control" name="fid" value={faculty.fid} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Faculty Name</label>
          <input type="text" className="form-control" name="facultyname" value={faculty.facultyname} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Designation</label>
          <input type="text" className="form-control" name="designition" value={faculty.designition} onChange={handleChange} required />
        </div>

        <div className="mb-3">
          <label className="form-label">Department</label>
          <select className="form-control" name="did" value={faculty.did} onChange={handleDepartmentChange} required>
            <option value="">Select Department</option>
            {departments.map((dept) => (
              <option key={dept.did} value={dept.did}>
                {dept.dname}
              </option>
            ))}
          </select>
        </div>

        <button type="submit" className="btn btn-success">
          <i className="bi bi-check-circle"></i> Submit
        </button>
        <button type="button" className="btn btn-secondary ms-2" onClick={() => navigate("/faculties")}>
          <i className="bi bi-arrow-left"></i> View Faculties
        </button>
      </form>
    </div>
  );
};

export default FacultyForm;
