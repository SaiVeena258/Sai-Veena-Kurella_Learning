import React from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Container, Row, Col, Card } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './Home.css';  

const images = [
  process.env.PUBLIC_URL + "/assets/image1.png",
  process.env.PUBLIC_URL + "/assets/image2.png",
  process.env.PUBLIC_URL + "/assets/image3.png",
  process.env.PUBLIC_URL + "/assets/image4.png"
];

const Home = () => {
  const navigate = useNavigate();

  return (
    <Container className="text-center mt-5">
      <h1 className="mb-3 heading">Effigo Global</h1>
      <h1 className="mb-4 heading">Event Management System</h1>
      <Button variant="primary" onClick={() => navigate('/events')} className="mb-4 btn-custom">
        View Events
      </Button>
      <br/><br/><br/>
      <Row className="justify-content-center">
        {images.map((img, index) => (
          <Col xs={12} md={6} lg={3} key={index} 
            className="mb-4 d-flex justify-content-center card-container"
            style={{ transform: (index % 2 !== 0) ? 'translateY(80px)' : 'translateY(0px)' }}>
            <Card className="event-card">
              <Card.Img variant="top" src={img} alt={`Event ${index + 1}`} className="event-img" />
            </Card>
          </Col>
        ))}
      </Row>
    </Container>
  );
};

export default Home;