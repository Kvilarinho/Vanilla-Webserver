import { projects } from "./data/projects.js";

const slug = new URLSearchParams(window.location.search).get("project");
const project = projects[slug];

//GO BACK BUTTON
    const goBackButton = document.getElementById("goBackButton");
    goBackButton.innerHTML = `<a class="exp-toggle"><span class="chev"><</span>Go Back</a>`;
    goBackButton.addEventListener("click", () => {
        window.history.back();
    });

if (!project) {
    document.getElementById("projectDescription").innerHTML = "<p>Project not found.</p>";
} else {

    
    // HERO IMAGE
    const heroImage = document.getElementById("projectHero");
    heroImage.innerHTML =
        `<img class="project-hero" src="${project.images.cover}" alt="${project.title}" />`;

    // DESCRIPTION
    document.getElementById("projectDescription").innerHTML = `
    <h2>${project.title}</h2>
    <p>${project.longDescription.intro}</p>
    <br/>
    ${project.images.previewImage 
        ? `<img src="${project.images.previewImage}" alt="${project.title} preview" class="project-hero"/>` : ""}
    <h3>Main Features</h3>
    <ul>${project.longDescription.features.map(f => `<li>${f}</li>`).join("")}</ul>
    ${project.longDescription.architecture ? `<h3>Architecture</h3><p>${project.longDescription.architecture}</p>` : ""}
    ${project.longDescription.testingAndDocs ? `<h3>Testing & Docs</h3><p>${project.longDescription.testingAndDocs}</p>` : ""}
    ${project.longDescription.collaboration ? `<h3>Collaboration</h3><p>${project.longDescription.collaboration}</p>` : ""}
    ${project.longDescription.learningOutcome ? `<h3>Learning Outcome</h3><p>${project.longDescription.learningOutcome}</p>` : ""}`;

    // TECHNOLOGIES
    document.getElementById("technologiesUsed").innerHTML = `
    <h2>Technologies Used</h2>
    ${renderTechSection("Backend", project.technologies.backend)}
    ${renderTechSection("Frontend", project.technologies.frontend)}
    ${renderTechSection("Tools", project.technologies.tools)}`;


    // GITHUB LINK
    const a = document.getElementById("githubLink");
    a.href = project.github;


    function renderTechSection(title, list) {
    if (!list?.length) return "";
    return `
        <h3>${title}</h3>
        <ul>${list.map(t => `<li>${t}</li>`).join("")}</ul>
    `;
}

}
