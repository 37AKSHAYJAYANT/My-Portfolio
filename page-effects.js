const footer = document.querySelector('.contact-footer');
const cursorEffect = document.querySelector('.cursor-effects');

if (footer && cursorEffect) {
  footer.addEventListener('mouseenter', () => {
    // Make the cursor visible
    cursorEffect.style.opacity = '1';
    cursorEffect.style.transform = 'scale(1)';
  });

  footer.addEventListener('mouseleave', () => {
    // Hide the cursor
    cursorEffect.style.opacity = '0';
    cursorEffect.style.transform = 'scale(0)';
  });

  footer.addEventListener('mousemove', (e) => {
    const rect = footer.getBoundingClientRect();

    // Get the cursor's dimensions to center it
    const cursorWidth = cursorEffect.offsetWidth;
    const cursorHeight = cursorEffect.offsetHeight;

    const x = e.clientX - rect.left - (cursorWidth / 2);
    const y = e.clientY - rect.top - (cursorHeight / 2);

    cursorEffect.style.left = x + 'px';
    cursorEffect.style.top = y + 'px';
  });
}