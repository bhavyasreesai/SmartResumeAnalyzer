async function analyze() {
    let fileInput = document.getElementById("fileInput");
    let job = document.getElementById("jobText").value;

    let resume = "";

    if (fileInput.files.length > 0) {
        let file = fileInput.files[0];
        resume = await file.text();
    } else {
        resume = document.getElementById("resumeText").value;
    }

    if (resume.trim() === "" || job.trim() === "") {
        document.getElementById("result").innerText = "Please provide resume and job description.";
        return;
    }

    const response = await fetch("http://localhost:8080/analyze", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            resume: resume,
            job: job
        })
    });

    const data = await response.json();

    document.getElementById("result").innerHTML = `
        <b>ATS Score:</b> ${data.score}% <br><br>
        <b>Matched Skills:</b> ${data.matchedSkills.join(", ")} <br><br>
        <b>Missing Skills:</b> ${data.missingSkills.join(", ")} <br><br>
        <b>Suggestion:</b> ${data.suggestion}
    `;
}