import React, { useState, useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import { Container, Row, Col, Card } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './Events.css';

const events = [
  { id: 1, img: "/assets/image5.png", title: "Countless Celebrations", description: "India, a land of diversity, celebrates countless festivals across states, each bringing a unique charm. From Lohri in Punjab to Pongal in Tamil Nadu, these festivals unite people through traditions, rituals, and vibrant festivities." },
  { id: 2, img: "/assets/image6.png", title: "Ugadi & Gudi Padwa", description: "Marking the beginning of a new year in Karnataka, Andhra Pradesh, Maharashtra, and Telangana, Ugadi and Gudi Padwa symbolize renewal and prosperity. Homes are decorated with mango leaves, families prepare traditional sweets and prayers are offered for a prosperous year ahead." },
  { id: 3, img: "/assets/image7.png", title: "Eid Mubarak", description: "Eid is a festival of gratitude, generosity, and joy. The day begins with prayers at mosques, followed by families coming together for a grand feast, which includes delicious dishes like Biryani, Sheer Khurma, and Kebabs." },
  { id: 4, img: "/assets/image8.png", title: "Ganesh Chaturthi", description: "A festival dedicated to Lord Ganesha, the remover of obstacles, Ganesh Chaturthi brings immense devotion and energy. Homes and streets are filled with beautifully crafted idols, devotional songs, and the aroma of Modaks." },
  { id: 5, img: "/assets/image9.png", title: "Diwali", description: "The festival of lights, Diwali, illuminates homes and hearts with happiness. People decorate their homes with diyas, rangoli, and lanterns, worship Goddess Lakshmi for prosperity, and enjoy firecrackers and sweets like Kaju Katli and Gulab Jamun." },
  { id: 6, img: "/assets/image10.png", title: "Christmas", description: "Christmas brings the magic of love, laughter, and giving. The air is filled with the melody of carols, sparkling decorations, and the scent of freshly baked cookies. Families gather around Christmas trees, exchange gifts, and enjoy a grand feast." }
];

const Events = () => {
  const [hoveredEvent, setHoveredEvent] = useState(null);
  const [position, setPosition] = useState({ top: 0, left: 0 });
  const navigate = useNavigate();
  
  const descriptionRef = useRef(null); 

  const handleMouseEnter = (event, eventData) => {
    const rect = event.currentTarget.getBoundingClientRect();
    setPosition({
      top: rect.top - 70, 
      left: rect.left + rect.width / 2 - 175
    });

    setHoveredEvent(eventData);
  };

  const handleMouseLeave = (event) => {
    if (event.relatedTarget && descriptionRef.current && !descriptionRef.current.contains(event.relatedTarget)) {
      setHoveredEvent(null);
    }
  };
  

  return (
    <Container className="text-center mt-5">
      <h1 className="mb-4 heading">Effigo Events</h1>
      <Row className="justify-content-center">
        {events.map((event) => (
          <Col xs={12} md={6} lg={4} key={event.id} className="mb-4 d-flex justify-content-center">
            <Card 
              className="event-card shadow-lg"
              onClick={() => navigate(`/events/${event.id}`)} 
              onMouseEnter={(e) => handleMouseEnter(e, event)}
              onMouseLeave={handleMouseLeave}
            >
              <Card.Img variant="top" src={event.img} alt={event.title} className="event-img" />
            </Card>
          </Col>
        ))}
      </Row>

      {hoveredEvent && (
        <div 
          className="description-box show-tooltip"
          style={{ top: `${position.top}px`, left: `${position.left}px` }}
          ref={descriptionRef} 
          onMouseLeave={handleMouseLeave}
        >
          <h4>{hoveredEvent.title}</h4>
          <p>{hoveredEvent.description}</p>
        </div>
      )}
    </Container>
  );
};

export default Events;
