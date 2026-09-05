document.addEventListener('DOMContentLoaded', () => {
  const EMAIL = 'Akshayjayant23@gmail.com';
  const GMAIL_COMPOSE = `https://mail.google.com/mail/?view=cm&to=${EMAIL}`;

  document.querySelectorAll('.email-link').forEach(link => {
    link.addEventListener('click', (e) => {
      e.preventDefault();

      let mailAppOpened = false;

      // Listen for page losing focus (mail app took over)
      const onBlur = () => { mailAppOpened = true; };
      window.addEventListener('blur', onBlur);

      // Try mailto: first
      window.location.href = `mailto:${EMAIL}`;

      // After 500ms, check if a mail app opened
      setTimeout(() => {
        window.removeEventListener('blur', onBlur);
        if (!mailAppOpened) {
          // No mail app detected — open Gmail compose in new tab
          window.open(GMAIL_COMPOSE, '_blank', 'noopener,noreferrer');
        }
      }, 500);
    });
  });
});
