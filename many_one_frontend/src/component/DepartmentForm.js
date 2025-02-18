import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import BASE_URL from './../api/bootapi';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';

const DepartmentForm = () => {
  const [department, setDepartment] = useState({ dname: '', did: '' });
  const [existingDepartments, setExistingDepartments] = useState([]);
  const navigate = useNavigate();

  // Fetch existing departments when component loads
  useEffect(() => {
    axios
      .get(`${BASE_URL}/department/displaydepart`)
      .then((response) => {
        if (Array.isArray(response.data)) {
          setExistingDepartments(response.data);
        }
      })
      .catch(() => {
        toast.error(' Error fetching existing departments!');
      });
  }, []);

  // Handle input change
  const handleChange = (e) => {
    setDepartment({ ...department, [e.target.name]: e.target.value });
  };

  // Check if department already exists
  const isDuplicate = () => {
    return existingDepartments.some(
      (dept) => dept.dname.toLowerCase() === department.dname.toLowerCase() || dept.did === department.did
    );
  };

  // Submit Department
  const submitDepartment = async () => {
    if (!department.dname || !department.did) {
      toast.error('Department Name and ID are required!');
      return;
    }

    if (isDuplicate()) {
      toast.warn(' This department already exists!');
      return;
    }

    try {
      await axios.post(`${BASE_URL}/department/adddepart`, department, {
        headers: { 'Content-Type': 'application/json' }
      });

      toast.success('Department added successfully!');
      setDepartment({ dname: '', did: '' }); // Clear form

      // Refresh the list of departments
      setExistingDepartments([...existingDepartments, department]);

    } catch (error) {
      if (error.response && error.response.status === 409) {
        toast.warn(' Department already exists!');
      } else {
        toast.error('Error adding department. Please try again!');
      }
    }
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">Add Department</h2>

      <form className="p-4 border rounded shadow-sm bg-light">
        <div className="mb-3">
          <label className="form-label">Department ID</label>
          <input
            type="text"
            name="did"
            className="form-control"
            value={department.did}
            onChange={handleChange}
            required
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Department Name</label>
          <input
            type="text"
            name="dname"
            className="form-control"
            value={department.dname}
            onChange={handleChange}
            required
          />
        </div>

        <div className="text-center">
          <button type="button" className="btn btn-success" onClick={submitDepartment}>
            <i className="bi bi-check-circle"></i> Submit
          </button>
          <button
            type="button"
            className="btn btn-info ms-2"
            onClick={() => navigate('/departments')}
          >
            <i className="bi bi-arrow-left"></i> View Departments
          </button>
        </div>
      </form>

      <ToastContainer position="top-right" autoClose={3000} />
    </div>
  );
};

export default DepartmentForm;
