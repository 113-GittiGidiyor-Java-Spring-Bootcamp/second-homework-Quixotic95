# Known Bugs

* While you sending a **DELETE REQUEST** with an **OBJECT** which has a **modified ID**, it deletes the **OBJECT that has the modified ID** instead of the **OBJECT itself**. *(An authorization problem due to business login more than a bug.)*
* You can't delete an instructor if he/she is **instructing a course**. *(Business logic more than a bug. / Probably could be changed with cascade types.)*

![homework](https://user-images.githubusercontent.com/45206582/129493929-01f3b3a7-793f-4057-959a-ac5fb05ad8a8.png)

## Example JSONs

### Students POST Method

```json
{
  "firstName": "Tolunay",
  "lastName": "Tasdemir",
  "address": "Ankara, Turkey",
  "birthDate": "1995-01-01",
  "gender": "MALE"
}
```

### Courses PUT method

```json
{
  "id": 2,
  "courseName": "Ataturk’s Principles and Turkish Revolution History",
  "courseCode": "ATA1001",
  "creditScore": 3,
  "courseStudents": [
    {
      "id": 1,
      "firstName": "Ahmet Emre",
      "lastName": "Oguz",
      "address": "Istanbul, Turkey",
      "birthDate": "1995-07-26",
      "gender": "MALE"
    },
    {
      "id": 6,
      "firstName": "Olivia",
      "lastName": "Parker",
      "address": "Gaborone, Botswana",
      "birthDate": "2001-04-22",
      "gender": "FEMALE"
    }
  ],
  "courseInstructor": {
    "id": 3,
    "firstName": "Belinda",
    "lastName": "Riley",
    "address": "Bordeaux, France",
    "phoneNumber": "207-2627-45",
    "instructorCourses": [],
    "fixedSalary": 6000.0
  }
}
```