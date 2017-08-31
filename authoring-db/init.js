db.createUser({ user: 'user', pwd: 'password', roles: [ {role:'readWrite', db:'survey'} ]});
db.surveys.insertOne(
{
  "_id": "1",
  "author": "Dragan Ljubojevic",
  "surveyTitle": "IT Survey",
  "published": false,
  "questions": [
    {
      "_id": NumberInt(0),
      "questionText": "What is your favorite IDE"
    },
    {
      "_id": NumberInt(1),
      "questionText": "What is your favorite programming language"
    },
    {
      "_id": NumberInt(2),
      "questionText": "What is your favorite OS"
    }
  ]
}
,
{ upsert: true }
);

db.answers.insertMany(
[
    {"answerText": "Linux", "surveyId":"1", "questionId":NumberInt(2)},
    {"answerText": "Windows", "surveyId":"1", "questionId":NumberInt(2)},
    {"answerText": "MAC OS", "surveyId":"1", "questionId":NumberInt(2)},

    {"answerText": "Java 8", "surveyId":"1", "questionId":NumberInt(1)},
    {"answerText": "Kotlin", "surveyId":"1", "questionId":NumberInt(1)},
    {"answerText": "Scala", "surveyId":"1", "questionId":NumberInt(1)},

    {"answerText": "IDEA Intelli J", "surveyId":"1", "questionId":NumberInt(0)},
    {"answerText": "Eclipse", "surveyId":"1", "questionId":NumberInt(0)},
    {"answerText": "Netbeans", "surveyId":"1", "questionId":NumberInt(0)},
]
);
