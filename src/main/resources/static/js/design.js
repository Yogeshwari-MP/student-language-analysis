// Get data from URL and display it
     /* const urlParams = new URLSearchParams(window.location.search);
      document.getElementById('name').textContent = urlParams.get('name');
      document.getElementById('rollNumber').textContent = urlParams.get('rollNumber');
      document.getElementById('department').textContent = urlParams.get('department');
      document.getElementById('programmingLanguage').textContent = urlParams.get('programmingLanguage');

      // Handle form submission
      const quizForm = document.getElementById('quizForm');
      const thankYouMessage = document.getElementById('thankYouMessage');

      quizForm.addEventListener('submit', function(event) {
          event.preventDefault(); // Prevent actual form submission
          quizForm.style.display = 'none'; // Hide the form
          thankYouMessage.style.display = 'block'; // Show the thank-you message
      });*/

/*const urlParams = new URLSearchParams(window.location.search);
		        document.getElementById('name').textContent = urlParams.get('student_name') || "Not Provided";
		        document.getElementById('rollNumber').textContent = urlParams.get('student_rollnum') || "Not Provided";
		        document.getElementById('department').textContent = urlParams.get('department_name') || "Not Provided";
		        document.getElementById('programmingLanguage').textContent = urlParams.get('prefered_language') || "Not Provided";

		        // Handle form submission
		        quizForm.addEventListener('submit', function (event) {
					event.preventDefault();
					
					const textareas = document.querySelectorAll('textarea[id^="palindromeProgram"]');
					    const programAnswers = Array.from(textareas).map((textarea) => textarea.value);
					
					  const formData = {
		                student_name: document.getElementById('name').textContent,
		                student_rollnum: document.getElementById('rollNumber').textContent,
		                department_name: document.getElementById('department').textContent,
		                prefered_language: document.getElementById('programmingLanguage').textContent,
		                program: programAnswers,
		            };

		            // AJAX Call to Backend
		            fetch("savedetails", {
		                method: "POST",
		                headers: {
		                    "Content-Type": "application/json",
		                },
		                body: JSON.stringify(formData),
		            })
		                .then((response) => {
		                    if (response.ok) {
		                        // Hide the form and display a thank-you message
		                        quizForm.style.display = 'none';
		                        thankYouMessage.style.display = 'block';
		                    } else {
		                        throw new Error("Failed to submit the form.");
		                    }
		                })
		                .catch((error) => {
		                    console.error("Error occurred:", error);
		                    alert("An error occurred while submitting the form.");
		                });
		        });
				
				$("#onsubmit").click(function(){
					window.location="registration";
				})*/
				const urlParams = new URLSearchParams(window.location.search);
						        document.getElementById('name').textContent = urlParams.get('student_name') || "Not Provided";
						        document.getElementById('rollNumber').textContent = urlParams.get('student_rollnum') || "Not Provided";
						        document.getElementById('department').textContent = urlParams.get('department_name') || "Not Provided";
						        document.getElementById('programmingLanguage').textContent = urlParams.get('prefered_language') || "Not Provided";
				
				
				let responses = [];
				
				
				/*document.addEventListener("DOMContentLoaded", function () {
				    
				});*/

				// Handle Form Submission
				document.getElementById("quizForm").addEventListener("submit", function (event) {
				    event.preventDefault();
					
					const questionDivs = document.querySelectorAll(".question-container"); // Selecting each question div

									    let totalScore = 0;
									  

									    questionDivs.forEach((questionDiv, index) => {
									        let selectedOption = questionDiv.querySelector("input[type='radio']:checked");
									        let correctAnswer = questionDiv.querySelector(".answers").value;
									        let program = questionDiv.querySelector(".program").value;
											let questionText = questionDiv.querySelector(".question").textContent;
											//let user_name=document.getElementById('name').textContent;

									        if (selectedOption) {
									            let isCorrect = selectedOption.value === correctAnswer;
									            if (isCorrect) {
									                totalScore += 1; // Increase score if correct
									            }

									            responses.push({
									                questionIndex: questionText,
									                selectedOption: selectedOption.value,
									                isCorrect: isCorrect,
									                program: program,
									            });
									        }
									    });
										
										

									    console.log("Responses:", responses);
									    console.log("Total Score:", totalScore);

				    const textareas = document.querySelectorAll('textarea[id^="palindromeProgram"]');
				    const programAnswers = Array.from(textareas).map((textarea) => textarea.value);

				    const formData = {
				        student_name: document.getElementById('name').textContent,
				        student_rollnum: document.getElementById('rollNumber').textContent,
				        department_name: document.getElementById('department').textContent,
				        prefered_language: document.getElementById('programmingLanguage').textContent,
				        program: programAnswers,
				    };
					const formData1 = {
										        userId: document.getElementById('name').textContent, // Ensure this matches backend expectations
										        responses: responses
										    };

				    // Send data to both "/savedetails" and "/submit"
				    Promise.all([
						fetch("savedetails", {
								                method: "POST",
								                headers: {
								                    "Content-Type": "application/json",
								                },
						 body: JSON.stringify(formData),
						}),
				        fetch("submit", {
				            method: "POST",
				            headers: { "Content-Type": "application/json" },
				            body:JSON.stringify(formData1),
				        })
				    ])
				    .then(responses => {
				        if (responses.every(response => response.ok)) {
				            document.getElementById("quizForm").style.display = "none";
				            document.getElementById("thankYouMessage").style.display = "block";
				        } else {
				            throw new Error("Failed to submit the form.");
				        }
				    })
				    .catch(error => {
				        console.error("Error:", error);
				        alert("An error occurred while submitting the form.");
				    });
				});

				// Redirect to registration page on clicking "Back to Home"
				document.getElementById("onsubmit").addEventListener("click", function () {
				    window.location = "registration";
				});
