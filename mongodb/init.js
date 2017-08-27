let res = db.createUser({ user: 'user', pwd: 'password', roles: [ {role:'readWrite', db:'survey'} ]})

db.surveys.insertOne(
{
  "_id":1,
  "author": "Dragan",
  "surveyTitle": "IT Survey",
  "questions": [
    {
      "_id": 1,
      "questionText": "What is your favorite IDE"
    },
    {
      "_id": 2,
      "questionText": "What is your favorite programming language"
    },
    {
      "_id": 3,
      "questionText": "What is your favorite OS"
    }
  ]
}
,
{ upsert: true }
);

db.answers.insertOne(
{
  "_id":1,
  "author": "Dragan",
  "surveyTitle": "IT Survey",
  "questions": [
    {
      "_id": 1,
      "questionText": "What is your favorite IDE"
    },
    {
      "_id": 2,
      "questionText": "What is your favorite programming language"
    },
    {
      "_id": 3,
      "questionText": "What is your favorite OS"
    }
  ]
}
,
{ upsert: true }
);


   "answers": [
        {"answerText": "Linux"},
        {
          "answerText": "Windows"
        },
        {
          "answerText": "MAC OS"
        }
      ]
"answers": [
        {
          "answerText": "Java"
        },
        {
          "answerText": "Scala"
        },
        {
          "answerText": "Kotlin"
        }
      ]

"answers": [
        {
          "answerText": "Eclipse"
        },
        {
          "answerText": "IntelliJ Idea"
        },
        {
          "answerText": "NetBeans"
        }
      ]