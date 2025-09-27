# Campus AI

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-17-orange?logo=java)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/SpringBoot-3.2.0-green?logo=spring)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql)](https://www.postgresql.org/)


**Campus AI** is a comprehensive web application designed to assist students in preparing for campus placements efficiently. It provides personalized guidance, practice, and evaluation tools to help students excel in technical interviews and resume assessment.  

---

## Features

Campus AI comes with several key features:  

### 1. Roadmap Generator
- Generate a roadmap for learning a tech stack.  
- Save and revisit your personalized roadmap anytime.  

### 2. Quiz Generation
- Create quizzes based on selected topics.  
- Specify the number of questions per quiz for targeted practice.  

### 3. DSA Practice Problems
- Generate coding practice questions based on topics, number of questions, and difficulty level.  
- Each problem includes:  
  - Difficulty level  
  - Company-specific tagging (companies where the question has been asked)  
  - Direct link to the problem  

### 4. ATS Resume Score Checker
- Upload your resume and a job description to calculate your ATS score.  
- Get detailed suggestions including:  
  - Strengths and weaknesses  
  - Missing keywords or skills  
  - Grammatical score  

### 5. Interview Experience Sharing
- Share your interview experiences.  
- Read experiences of other students to get insights into interview processes.  

---

## Tech Stack

Campus AI is built using a robust and scalable microservices architecture with the following technologies:  

- **Backend:** Java, Advanced Java, Spring MVC, Spring Boot, Spring Security  
- **AI Integration:** Spring AI, Google Gemini  
- **API Documentation:** Swagger  
- **Database:** PostgreSQL, Hibernate, Spring JPA  
- **Architecture:** Microservices (User Service, Roadmap Service, Quiz Service, DSA Service, ATS-Checker Service, Interview Service)  
- **API Gateway:** For routing requests to respective services  
- **Principles:** Fully follows SOLID principles for maintainable and scalable code  

---

## Microservices Architecture

Campus AI is designed on a fully **microservices architecture**, which ensures:  
- Scalability and robustness  
- Independent deployment of services  
- Clear separation of concerns  

### Services

- **User Service:** Manages user authentication, registration, and profiles  
- **Roadmap Service:** Handles tech stack roadmap generation and storage  
- **Quiz Service:** Manages quiz creation and retrieval  
- **DSA Service:** Generates coding problems based on input criteria  
- **ATS-Checker Service:** Evaluates resumes against job descriptions  
- **Interview Service:** Facilitates sharing and reading of interview experiences  

---

## Getting Started

1. Clone the repository:  
   ```bash
   git clone <repository-url>
   ```
2. Run the project using your IDE or via terminal.
3. Access the API documentation using Swagger:
   ```bash
    http://localhost:8083/swagger-ui/index.html
   ```
4. Explore and interact with all available APIs.
     
