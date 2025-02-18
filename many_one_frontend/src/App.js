// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import DepartmentList from './component/DepartmentList';
import DepartmentForm from './component/DepartmentForm';
import FacultyList from './component/FacultyList';
import FacultyForm from './component/FacultyForm';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';
import Home from './component/Home'; 

const App = () => {
  return (
    <Router>
      <div>
        {/* Navbar */}
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
          <div className="container-fluid">
            <Link className="navbar-brand" to="/">Dashboard</Link>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav ms-auto">
                <li className="nav-item"><Link className="nav-link" to="/">Home</Link></li>
                <li className="nav-item"><Link className="nav-link" to="/departments">Departments</Link></li>
                <li className="nav-item"><Link className="nav-link" to="/faculties">Faculties</Link></li>
                <li className="nav-item"><Link className="nav-link" to="/department/add">Add Department</Link></li>
                <li className="nav-item"><Link className="nav-link" to="/faculty/add">Add Faculty</Link></li>
              </ul>
            </div>
          </div>
        </nav>

        {/* Main Content */}
        <div className="container mt-4">
          <Routes>
            {/* Home Page */}
            <Route path="/" element={<Home/>}/>

            {/* Department Routes */}
            <Route path="/departments" element={<DepartmentList />} />
            <Route path="/department/add" element={<DepartmentForm />} />
            <Route path="/department/edit/:id" element={<DepartmentForm />} />

            {/* Faculty Routes */}
            <Route path="/faculties" element={<FacultyList />} />
            <Route path="/faculty/add" element={<FacultyForm />} />
            <Route path="/faculty/edit/:id" element={<FacultyForm />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;