# QC/QA Validator

This is a Spring Boot application designed to manage the Quality Control (QC) and Quality Assurance (QA) process for electric vehicles. The system allows for the creation and tracking of vehicles, inspectors, inspection checklists, and inspection logs.

---

## Technologies Used

*   **Java 17**
*   **Spring Boot 3.2.3**
    *   Spring Web
    *   Spring Data JPA
    *   Spring Boot Starter Validation
*   **PostgreSQL**: Application database
*   **Maven**: Dependency Management
*   **Lombok**: To reduce boilerplate code

---

## Setup and Installation

Follow these steps to get the project running on your local machine.

### Prerequisites

*   **JDK 17** or later installed.
*   **Apache Maven** installed.
*   **PostgreSQL** server running.
*   An IDE like IntelliJ IDEA or VS Code.

### Steps

1.  **Clone the repository:**
    ```sh
    git clone <your-repository-url>
    cd QCQA-Validator
    ```

2.  **Create the Database:**
    *   Open your PostgreSQL admin tool (like `psql` or pgAdmin).
    *   Create a new database for the project.
      ```sql
      CREATE DATABASE your_database_name;
      ```

3.  **Configure the Application:**
    *   Open the `src/main/resources/application.properties` file.
    *   Update the following properties with your PostgreSQL database details:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
      spring.datasource.username=your_postgres_username
      spring.datasource.password=your_postgres_password
      ```

4.  **Build and Run the Application:**
    *   Open a terminal in the project's root directory.
    *   Run the application using the Spring Boot Maven plugin:
      ```sh
      mvn spring-boot:run
      ```
    *   The application will start on `http://localhost:8080`.

---

## API Endpoints

The following is a summary of the available REST API endpoints.

### Vehicles (`/api/vehicles`)

*   `POST /` - Creates a new vehicle.
*   `GET /` - Retrieves a list of all vehicles.
*   `GET /{id}` - Retrieves a specific vehicle by its ID.
*   `GET /by-serial/{serialNumber}` - Retrieves a vehicle by its serial number.

### QC Persons (`/api/qc-persons`)

*   `POST /` - Creates a new QC inspector.
*   `GET /` - Retrieves a list of all QC inspectors.
*   `GET /{id}` - Retrieves a specific QC inspector by their ID.

### Checklists (`/api/checklists`)

*   `POST /` - Creates a new checklist item.
*   `GET /` - Retrieves all checklist items.
*   `GET /by-vehicle-type/{vehicleType}` - Retrieves all checklist items for a specific vehicle type (e.g., `BIKE`, `CAR`).

### Inspection Logs (`/api/inspection-logs`)

*   `POST /` - Creates a new inspection log.
*   `GET /` - Retrieves all inspection logs.
*   `GET /{id}` - Retrieves a specific inspection log by its ID.
