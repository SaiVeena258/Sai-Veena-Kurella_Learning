import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { Container, Row, Col, Card } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "./EventDetails.css";

const EventDetails = () => {
    const { eventId } = useParams();
    const eventIdNum = Number(eventId);

    const [event, setEvent] = useState(null);
    const [organizers, setOrganizers] = useState([]);
    const [speakers, setSpeakers] = useState([]);
    const [attendees, setAttendees] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [openSections, setOpenSections] = useState({
        organizer: false,
        speakers: false,
        attendees: false,
    });

    useEffect(() => {
        const fetchEventData = async () => {
            try {
                console.log(`Fetching event data for event ID: ${eventIdNum}`);

                const eventResponse = await axios.get(`http://localhost:8085/api/events/${eventIdNum}`);
                setEvent(eventResponse.data);

                const organizersResponse = await axios.get(`http://localhost:8085/api/events/${eventIdNum}/organizers`);
                setOrganizers(organizersResponse.data);

                try {
                    const speakersResponse = await axios.get(`http://localhost:8085/api/speakers/event/${eventIdNum}`);
                    setSpeakers(speakersResponse.data.map((spk, index) => ({
                        id: spk.id || `spk-${index}`,
                        name: spk.username,
                        topic: spk.topic || "No topic available"
                    })));
                } catch (error) {
                    console.warn("Speakers API failed, skipping.");
                }

                try {
                    const attendeesResponse = await axios.get(`http://localhost:8085/api/events/${eventIdNum}/attendees`);
                    console.log("Attendees API Response:", attendeesResponse.data); 

                    const formattedAttendees = attendeesResponse.data.map((name, index) => ({
                        id: `att-${index}`, 
                        name: name || "Unknown Attendee"
                    }));

                    setAttendees([...formattedAttendees]); 
                } catch (error) {
                    console.warn("Attendees API failed, skipping.");
                }
                
            } catch (error) {
                console.error("Error fetching event details:", error);
                setError("Failed to load event details.");
            } finally {
                setLoading(false);
            }
        };

        fetchEventData();
    }, [eventIdNum]);

    if (loading) return <h2 className="text-center mt-5">Loading event details...</h2>;
    if (error) return <h2 className="text-center mt-5 text-danger">{error}</h2>;
    if (!event) return <h2 className="text-center mt-5">Event not found.</h2>;

    const toggleSection = (section) => {
        setOpenSections((prev) => ({ ...prev, [section]: !prev[section] }));
    };

    return (
        <Container className="mt-5 event-container">
            <h2 className="text-center event-title">{event.eventname || "Event Details"}</h2>
            <div className="title-underline"></div>
            <p className="text-center">{event.description}</p>
            <div className="event-box">
                <Row className="mt-4">
                    {/* Organizers */}
                    <Col md={4}>
                        <Card className="p-3 organizer-card">
                            <h4 className="text-center collapsible-title" onClick={() => toggleSection("organizer")}>
                                Organizers
                            </h4>
                            {openSections.organizer && (
                                <ul className="list-group mt-2">
                                    {organizers.length > 0 ? (
                                        organizers.map(org => (
                                            <li key={org.id} className="list-group-item">{org.username}</li>
                                        ))
                                    ) : (
                                        <li className="list-group-item">No organizers available</li>
                                    )}
                                </ul>
                            )}
                        </Card>
                    </Col>

                    {/* Speakers */}
                    <Col md={4}>
                        <Card className="p-3 speaker-card">
                            <h4 className="text-center collapsible-title" onClick={() => toggleSection("speakers")}>
                                Speakers
                            </h4>
                            {openSections.speakers && (
                                <ul className="list-group mt-2">
                                    {speakers.length > 0 ? (
                                        speakers.map(spk => (
                                            <li key={spk.id} className="list-group-item">{spk.name} - {spk.topic}</li>
                                        ))
                                    ) : (
                                        <li className="list-group-item">No speakers available</li>
                                    )}
                                </ul>
                            )}
                        </Card>
                    </Col>

                    {/* Attendees */}
                    <Col md={4}>
                        <Card className="p-3 attendee-card">
                            <h4 className="text-center collapsible-title" onClick={() => toggleSection("attendees")}>
                                Attendees
                            </h4>
                            {openSections.attendees && (
                                <div className="scrollable-list mt-2">
                                    <ul className="list-group">
                                        {attendees.length > 0 ? (
                                            attendees.map(att => (
                                                <li key={att.id} className="list-group-item">{att.name}</li>
                                            ))
                                        ) : (
                                            <li className="list-group-item">No attendees available</li>
                                        )}
                                    </ul>
                                </div>
                            )}
                        </Card>
                    </Col>
                </Row>
            </div>
        </Container>
    );
};

export default EventDetails;