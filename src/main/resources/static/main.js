// const mainParent = document.getElementById("main");
//
// function LukasSmrdi(title, description) {
//     const aElement = document.createElement('a');
//     mainParent.appendChild(aElement);
//     const problemyDiv = document.createElement('div');
//     problemyDiv.classList.add('problemy');
//
//     aElement.appendChild(problemyDiv);
// }
//
// LukasSmrdi("ahoj", "ahoj");
// LukasSmrdi("ahoj", "ahoj");

const timeButtons = document.getElementsByClassName("time-button")
let interval
let time

for (let i = 0; i < timeButtons.length; i++) {
    let timeButton = timeButtons[i]
    timeButton.addEventListener("click", (e) => {
        if (timeButton.innerText === "Start") {
            calculateTime(timeButton)
        } else if (timeButton.innerText === "Stop") {
            clearInterval(interval)
            console.log(time)
            sendRequest(time, timeButton)
        }
    })
}

const calculateTime = function(timeButton) {
    time = 0;
    timeButton.innerText = "Stop"
    interval = setInterval((e) => {
        time += 1;
    }, 1000)
}

const sendRequest = async function(time, timeButton) {
    console.log(timeButton)
    let requestData = {0: time}
    const response = await fetch('/api/complete-problem/' + timeButton.id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestData)
    });

    if (!response.ok) {
        // Handle HTTP errors
        const errorData = await response.json();
        console.error('Error:', errorData);
        alert(`Failed to complete problem: ${response.statusText}`);
    } else {
        // Successfully handled
        alert('Problem completed successfully!');
    }
}
