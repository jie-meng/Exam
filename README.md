# Exam

## run

```
./gradlew run
```

serve on localhost:8080
    
## API

### fetchBlankQuiz

```
url: {baseUrl}/blankquiz
method: GET
```

### createBlankQuiz

```
url: {baseUrl}/blankquiz
method: POST
body: 
{
	"question": "question 1",
	"referenceAnswer": "answer 1"
}
```

### fetchPaper 

```
url: {baseUrl}/paper
method: GET
```

### assemblePaper

```
url: {baseUrl}/paper
method: POST
body: 
{
	"blankQuizzes": [
		{
			"id": "BlankQuiz_873af207-a274-4a53-a8fd-dc908a554113",
			"score": 50
		}
	]
}
```

### reassemblePaper

```
url: {baseUrl}/paper/{paperId}
method: PUT
body: 
{
	"blankQuizzes": [
		{
			"id": "BlankQuiz_873af207-a274-4a53-a8fd-dc908a554116",
			"score": 30
		}
	]
}
```
