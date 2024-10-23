let problemForm = document.getElementById("add-problem")


let problem = {
    title: document.getElementById("title"),
    description: document.getElementById("description"),
}

problemForm.addEventListener("submit", (e) => {
    e.preventDefault();

    console.log(document.getElementById("title").value)

    fetch(document.location.href, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "name": problem.title.value,
            "comment": problem.description.value,
            "classId": "Alfa",
        }),
    })

    for (const [key, value] of Object.entries(problem)) {
        value.textContent = ""
    }
})