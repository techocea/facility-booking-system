INSERT INTO users (name,email,password,role,created_at) VALUES
('Admin User', 'admin@example.com', 'admin123', 'ROLE_ADMIN', CURRENT_TIMESTAMP),
('John Doe', 'john@example.com', 'user123', 'ROLE_CUSTOMER', CURRENT_TIMESTAMP);

INSERT INTO facility_categories (name) VALUES
    ('Event Space'),
    ('Conference Hall'),
    ('Studio'),
    ('Meeting Room'),
    ('Sports Court'),
    ('Workspace');

INSERT INTO facilities (name, description, capacity, hourly_rate, is_active, requires_approval, category_id) VALUES
('Skyline Boardroom','A sleek, glass-walled boardroom with panoramic city views. Perfect for executive meetings, strategic planning sessions, and high-stakes presentations. Features a 75-inch smart display and premium leather seating.', 12, 1000.00, true, false,4),
('Theater Performance Hall','An elegant theater hall with 120 red velvet seats, a professional stage with curtains, and advanced lighting. Ideal for plays, dance recitals, and musical performances.', 120, 100000.00, true, true, 1),
('Grand Conference Hall','A spacious conference hall accommodating up to 200 guests. Ideal for corporate conferences, seminars, product launches, and large-scale presentations. Features professional AV equipment and tiered seating.', 200, 10000.00, true, true, 2),
('Royal Auditorium','A magnificent auditorium with 150 plush seats, a large stage, and state-of-the-art sound. Perfect for lectures, performances, award ceremonies, and community events.', 150, 8000.00, true, true, 2),
('Champions Court','A professional-grade indoor basketball court with maple hardwood flooring, electronic scoreboards, and bleacher seating for 80 spectators. Available for games, practices, and tournaments.', 80, 5000.00, true, true, 5),
('Harmony Recording Studio','A professional recording studio with acoustically treated rooms, industry-standard mixing console, and a vocal booth. Perfect for music production, podcasts, voiceovers, and audio post-production.', 6, 6500.00, true, true, 3),
('Collaborate Coworking Space','A bright, open coworking area with 24 hot desks, standing desks, and comfortable lounge zones. Includes high-speed internet, unlimited coffee, and access to meeting pods.', 24, 7500.00, true, false, 6);