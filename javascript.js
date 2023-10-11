// Smooth scrolling for anchor links
document.addEventListener("DOMContentLoaded", function () {
    const navLinks = document.querySelectorAll('nav a');
    navLinks.forEach((link) => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            const targetId = link.getAttribute('href').substring(1);
            const targetSection = document.getElementById(targetId);
            window.scrollTo({
                top: targetSection.offsetTop,
                behavior: 'smooth',
            });
        });
    });
});

// Dark mode toggle with animation
const darkModeToggle = document.getElementById('dark-mode-toggle');
darkModeToggle.addEventListener('change', () => {
    document.body.classList.toggle('dark-mode');
    // Animate the label background color
    darkModeToggle.parentElement.style.backgroundColor = darkModeToggle.checked ? '#007BFF' : '#ccc';
});

// Form submission handling with stylish animation
const contactForm = document.getElementById('contact-form');
contactForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const formData = new FormData(contactForm);
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    // Simulate a loading animation while submitting (you can replace this with actual submission logic)
    const submitButton = contactForm.querySelector('button[type="submit"]');
    submitButton.innerHTML = '<span class="loader"></span>Sending...';
    submitButton.disabled = true;

    setTimeout(() => {
        // Replace the loading animation with a success message (you can customize this further)
        submitButton.innerHTML = 'Message Sent!';
        contactForm.reset();
        setTimeout(() => {
            submitButton.innerHTML = 'Send Message';
            submitButton.disabled = false;
        }, 3000); // Reset after 3 seconds
    }, 2000); // Simulate a 2-second delay (adjust as needed)

    // You can add your code here to send the message or save it to a database.
    // For example, you can use JavaScript's Fetch API to send the data to a backend script.
    // Here's a simple example using Fetch:
    /*
    fetch('/your-backend-endpoint', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then((response) => {
        if (response.ok) {
            // Handle success
            console.log('Message sent successfully.');
            // You can also display a success message to the user.
        } else {
            // Handle errors
            console.error('Message sending failed.');
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    });
    */
});