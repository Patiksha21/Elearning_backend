INSERT INTO courses (title, description, image_url) VALUES
('Web Development Bootcamp', 'Build modern websites with HTML, CSS JavaScript.', 'Assets/Images/Web_developement.jpg'),
('Python for Beginners', 'Learn Python fundamentals, write scripts, and solve tasks. Perfect for first-time programmers.', 'Assets/Images/Python_Developer.jpg'),
('Data Science Essentials', 'Analyze and visualize data using Python Pandas, Matplotlib. Intro to ML concepts and projects.', 'Assets/Images/Data_science.jpg'),
('Digital Marketing Mastery', 'SEO, social media campaigns grow brands online with practical tactics and analytics insights.', 'Assets/Images/Digital_Marketing.jpg'),
('Graphic Design Fundamentals', 'Learn layout, color, typography and tools PhotoshopIllustrator to design eye-catching visuals.', 'Assets/Images/Graphic_design.jpg'),
('Cybersecurity Basics', 'Understand threats, basics of network security, and practical steps to protect systems and data.', 'Assets/Images/Cyber_security.jpg'),
('Machine Learning Basics', 'Learn supervised and unsupervised ML models using Python libraries like scikit-learn.', 'Assets/Images/Machine_learning.jpg'),
('Cloud Computing with AWS', 'Get hands-on with AWS services like EC2, S3, and Lambda to deploy scalable apps.', 'Assets/Images/Cloud-Computing.webp'),
('UIUX Design Fundamentals', 'Learn how to design engaging and user-friendly interfaces. Understand user research, wireframing, and prototyping with modern design tools.', 'Assets/Images/UI_UX.png'),
('DevOps CICD', 'Understand DevOps principles and tools. Set up CICD pipelines to automate builds, testing, and deployment of applications.', 'Assets/Images/Dev_Ops.png'),
('Cyber Security Essentials', 'Understand ethical hacking, network security, and secure coding practices to protect systems and data from modern threats.', 'Assets/Images/cyber_security.jpg');


-- =============================================
-- SYLLABUS DATA (Must run AFTER course INSERTs)
-- The course_id assumes the courses above were inserted in order.
-- =============================================

-- 1. Web Development Bootcamp (course_id = 1)
INSERT INTO course_syllabus (course_id, topic) VALUES
(1, 'HTML5 Fundamentals'),
(1, 'CSS3 & Flexbox/Grid Layout'),
(1, 'JavaScript ES6+ Basics'),
(1, 'DOM Manipulation & Events'),
(1, 'Responsive Design'),
(1, 'Introduction to React/Vue');

-- 2. Python for Beginners (course_id = 2)
INSERT INTO course_syllabus (course_id, topic) VALUES
(2, 'Python Syntax and Variables'),
(2, 'Data Structures: Lists, Tuples, Dictionaries'),
(2, 'Control Flow: If/Else, Loops'),
(2, 'Functions and Modules'),
(2, 'File Handling'),
(2, 'Introduction to OOP');

-- 3. Data Science Essentials (course_id = 3)
INSERT INTO course_syllabus (course_id, topic) VALUES
(3, 'Data Cleaning with Pandas'),
(3, 'Data Visualization with Matplotlib/Seaborn'),
(3, 'Statistical Concepts'),
(3, 'Introduction to Machine Learning'),
(3, 'Exploratory Data Analysis (EDA)');

-- 4. Digital Marketing Mastery (course_id = 4)
INSERT INTO course_syllabus (course_id, topic) VALUES
(4, 'Search Engine Optimization (SEO)'),
(4, 'Social Media Marketing Strategies'),
(4, 'Content Marketing'),
(4, 'Email Marketing Campaigns'),
(4, 'Google Analytics and Reporting');

-- 5. Graphic Design Fundamentals (course_id = 5)
INSERT INTO course_syllabus (course_id, topic) VALUES
(5, 'Principles of Design: Layout and Balance'),
(5, 'Color Theory and Typography'),
(5, 'Adobe Photoshop Basics'),
(5, 'Adobe Illustrator Basics'),
(5, 'Branding and Logo Design');

-- 6. Cybersecurity Basics (course_id = 6)
INSERT INTO course_syllabus (course_id, topic) VALUES
(6, 'Understanding Cyber Threats'),
(6, 'Network Security Fundamentals'),
(6, 'Authentication and Access Control'),
(6, 'Malware and Antivirus Solutions'),
(6, 'Basic Cryptography');

-- 7. Machine Learning Basics (course_id = 7)
-- NOTE: The list of courses you provided jumps from ID 6 to ID 8 in your previous log, but since you removed the IDs in the new script, the *new* ID for Machine Learning Basics will be 7 (the 7th course inserted).
INSERT INTO course_syllabus (course_id, topic) VALUES
(7, 'Supervised Learning (Regression/Classification)'),
(7, 'Unsupervised Learning (Clustering)'),
(7, 'Model Evaluation and Metrics'),
(7, 'Scikit-learn Library Introduction'),
(7, 'Data Preprocessing');

-- 8. Cloud Computing with AWS (course_id = 8)
INSERT INTO course_syllabus (course_id, topic) VALUES
(8, 'Introduction to Cloud Concepts'),
(8, 'AWS Global Infrastructure'),
(8, 'EC2 (Compute) Setup'),
(8, 'S3 (Storage) Management'),
(8, 'AWS Lambda (Serverless)');

-- 9. UIUX Design Fundamentals (course_id = 9)
INSERT INTO course_syllabus (course_id, topic) VALUES
(9, 'User Research and Personas'),
(9, 'Wireframing and Prototyping (Figma/Sketch)'),
(9, 'Information Architecture'),
(9, 'Usability Testing'),
(9, 'Design Systems and Component Libraries');

-- 10. DevOps CICD (course_id = 10)
INSERT INTO course_syllabus (course_id, topic) VALUES
(10, 'DevOps Culture and Principles'),
(10, 'Version Control with Git'),
(10, 'Continuous Integration (CI) with Jenkins/GitLab'),
(10, 'Containerization with Docker'),
(10, 'Deployment Automation');

-- 11. Cyber Security Essentials (course_id = 11)
-- NOTE: Since you have two "Cybersecurity" courses, this assumes the "Essentials" course is the 11th in the list.
INSERT INTO course_syllabus (course_id, topic) VALUES
(11, 'Ethical Hacking Methodologies'),
(11, 'Vulnerability Assessment'),
(11, 'Secure Coding Practices'),
(11, 'Incident Response Basics'),
(11, 'Risk Management');