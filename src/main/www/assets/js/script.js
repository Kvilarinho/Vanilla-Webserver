function showExperienceDetails() {
    const details = document.getElementById('experience-details');
    if (details.style.display === 'none' || details.style.display === '') {
        details.style.display = 'block';
    } else {
        details.style.display = 'none';
    }
};

function showAboutDetails() {
    const aboutDetails = document.getElementById('about-details');
    if (aboutDetails.style.display === 'none' || aboutDetails.style.display === '') {
        aboutDetails.style.display = 'block';
    } else {
        aboutDetails.style.display = 'none';
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const yearSpan = document.getElementById('year');
    if (yearSpan) {
        yearSpan.textContent = new Date().getFullYear();
    }
});

