**Autori:**  
- Alija Subašić  
- Amar Berbić  

## Opis aplikacije
Ova aplikacija je web aplikacija razvijena u Spring Boot-u koristeći Thymeleaf za frontend. Omogućava pregled i upravljanje ljubimcima (`Pet`) i njihovim terminima (`Appointments`).  

### Model i relacije
- **Pet**  
  - id (int)  
  - name (String)  
  - type (String)  
  - appointments (List<Appointments>)  

- **Appointments**  
  - id (int)  
  - dateTime (LocalDateTime)  
  - description (String)  

**Relacija:**  
Jedan `Pet` može imati više `Appointments` (1:N relacija).

Screenhot: <img width="367" height="188" alt="image" src="https://github.com/user-attachments/assets/e071d9e7-26af-4511-9fa4-3be39fc5c226" />
