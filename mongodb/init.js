let res = db.createUser({ user: 'user', pwd: 'password', roles: [ {role:'readWrite', db:'survey'} ]})

db.survey.insertOne(
{

  "author": "Dragan",
  "surveyTitle": "IT Survey",
  "questions": [
    {
      "id": 1,
      "questionText": "What is your favorite IDE",
      "answers": [
        {
          "id": 1,
          "answerText": "Eclipse"
        },
        {
          "id": 2,
          "answerText": "IntelliJ Idea"
        },
        {
          "id": 3,
          "answerText": "NetBeans"
        }
      ]
    },
    {
      "id": 2,
      "questionText": "What is your favorite programming language",
      "answers": [
        {
          "id": 1,
          "answerText": "Java"
        },
        {
          "id": 2,
          "answerText": "Scala"
        },
        {
          "id": 3,
          "answerText": "Kotlin"
        }
      ]
    },
    {
      "id": 3,
      "questionText": "What is your favorite OS",
      "answers": [
        {
          "id": 1,
          "answerText": "Linux"
        },
        {
          "id": 2,
          "answerText": "Windows"
        },
        {
          "id": 3,
          "answerText": "MAC OS"
        }
      ]
    }
  ]
}
,
{ upsert: true }
);