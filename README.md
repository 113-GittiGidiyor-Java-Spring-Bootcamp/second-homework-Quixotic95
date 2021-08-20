# İkinci ödev teslim tarihi : 22 Ağustos - 23:00

### Not : ARAŞTIRMA KONUSU kısmı tamamıyla sizleri geliştirmek amaçlı , eklenmiştir , o madde için herhangi bir kod vs örneğine ihtiyaç yoktur.

![homework](https://user-images.githubusercontent.com/45206582/129493929-01f3b3a7-793f-4057-959a-ac5fb05ad8a8.png)

## Example JSONs

### Students POST Method

```json
{
  "firstName": "Emre",
  "lastName": "OGUZ",
  "address": "Istanbul, Turkey",
  "birthDate": "1995-07-26",
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