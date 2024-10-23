let problemForm = document.getElementById("add-problem")
let title = document.getElementById("title")

// let problem = {
//     title: document.getElementById("title"),
//     description: document.getElementById("description"),
// }

problemForm.addEventListener("submit", (e) => {
    e.preventDefault();

    // for (let input of problem) {
    //     input.textContent = ""
    // }

    // $.ajax({
    //     type: "POST",
    //     url: document.location,
    //     body: {
    //         "name": problem.title,
    //         "core": null,
    //         "comment": problem.description,
    //         "created": null,
    //         "started": null,
    //         "ended": null,
    //     },
    //     headers: {
    //         "Content-Typ"
    //     }
    // })

    fetch(document.location, {
        method: "POST",
        body: JSON.stringify({
            "name": title.textContent,
            "core": null,
            "comment": "problem.description.textContent",
            "created": null,
            "started": null,
            "ended": null,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    })

    // var xhr = new XMLHttpRequest()
    // xhr.open("POST", document.location, true)
    // xhr.setRequestHeader("Content-Type", "application/json")
    // var data = JSON.stringify({
    //     "name": problem.title,
    //     "core": null,
    //     "comment": problem.description,
    //     "created": null,
    //     "started": null,
    //     "ended": null,
    // })
    // xhr.send(data)
})