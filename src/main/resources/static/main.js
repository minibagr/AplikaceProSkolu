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
    let requestData = {0: time / 60}
    const response = await fetch('/api/complete-problem/' + timeButton.id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestData)
    });
    if (response.ok) {
        window.location.reload()
    }
}

const DeleteUser = async function(id) {
    await fetch('/api/delete-user/' + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        if (response.ok) {
            window.location.href = "/problemy"; // Redirect in frontend
        }
    });
}

function ShowProblem(id) {
    let problemDiv = document.getElementById(id);

    if(problemDiv.classList.contains("expand")) {
        problemDiv.classList.remove("expand");
    } else {
        problemDiv.classList.add("expand");
    }
}

document.addEventListener("DOMContentLoaded", function () {
    const searchInput = document.getElementById("searchInput");
    const problems = document.querySelectorAll(".problemy");

    searchInput.addEventListener("input", function () {
        const searchTerm = searchInput.value.toLowerCase();

        problems.forEach(function (problem) {
            const problemTitle = problem.querySelector("h3").textContent.toLowerCase();

            if (problemTitle.includes(searchTerm)) {
                problem.style.display = "block";
            } else {
                problem.style.display = "none";
            }
        });
    });
});

let buttonCLick = 0;
let originalOrder = [];

document.addEventListener("DOMContentLoaded", function () {
    const problemsContainer = document.getElementById("main");
    const problems = Array.from(problemsContainer.querySelectorAll(".problemy"));

    originalOrder = problems.map(problem => problem);
});

function filterProblemsByDate() {
    const problemsContainer = document.getElementById("main");
    const problems = Array.from(problemsContainer.querySelectorAll(".problemy"));

    if (buttonCLick === 0) {
        problems.sort((a, b) => {
            const dateA = new Date(a.querySelector("h4").textContent.replace(/[()]/g, ""));
            const dateB = new Date(b.querySelector("h4").textContent.replace(/[()]/g, ""));
            return dateA - dateB;
        });
    } else if (buttonCLick === 1) {
        problems.sort((a, b) => {
            const dateA = new Date(a.querySelector("h4").textContent.replace(/[()]/g, ""));
            const dateB = new Date(b.querySelector("h4").textContent.replace(/[()]/g, ""));
            return dateB - dateA;
        });
    } else if (buttonCLick === 2) {
        problemsContainer.innerHTML = "";
        originalOrder.forEach(problem => problemsContainer.appendChild(problem));
        buttonCLick = -1;
    }

    if (buttonCLick !== -1) {
        problems.forEach(problem => problemsContainer.appendChild(problem));
    }

    buttonCLick++;
}

const sortButton = document.getElementById("sortButton");
if (sortButton) sortButton.addEventListener("click", filterProblemsByDate);
