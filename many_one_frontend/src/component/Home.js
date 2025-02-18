// src/component/Home.js
import React from 'react';
import homepageImage1 from '../assets/image1.png'; 
import homepageImage2 from '../assets/image2.png';
import 'bootstrap/dist/css/bootstrap.min.css';

const Home = () => {
  return (
    <div className="container d-flex flex-column justify-content-center align-items-center min-vh-75">
      {/* Heading & Description */}
      <div className="text-center">
        <h2 className="fw-bold">Welcome to the Dashboard</h2>
        <p className="text-muted">Use the navigation bar to manage Departments and Faculties.</p>
      </div>
      <br/><br/>

      {/* Image Section */}
      <div className="row mt-4 justify-content-center align-items-center">
        <div className="col-md-5 mb-3 d-flex justify-content-center">
          <div className="card border-0 shadow-sm">
            <img 
              src={homepageImage1} 
              alt="BE/BTech Departments" 
              className="img-fluid rounded"
              style={{ height: '280px', objectFit: 'cover', transition: 'transform 0.3s ease' }}
              onMouseOver={(e) => e.target.style.transform = "scale(1.05)"}
              onMouseOut={(e) => e.target.style.transform = "scale(1.0)"}
            />
          </div>
        </div>
        <div className="col-md-5 mb-3 d-flex justify-content-center">
          <div className="card border-0 shadow-sm">
            <img 
              src={homepageImage2} 
              alt="Faculty Ranks" 
              className="img-fluid rounded"
              style={{ height: '280px', objectFit: 'cover', transition: 'transform 0.3s ease' }}
              onMouseOver={(e) => e.target.style.transform = "scale(1.05)"}
              onMouseOut={(e) => e.target.style.transform = "scale(1.0)"}
            />
          </div>
        </div>
      </div><br/><br/>
      <div>
      <h4><i>"Faculties inspire, departments empower—together, they shape the future."</i> </h4>
      </div>
    </div>
  );
};

export default Home;
