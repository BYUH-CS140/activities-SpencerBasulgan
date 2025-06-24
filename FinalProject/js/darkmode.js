function applySavedMode() {
  const savedMode = localStorage.getItem('theme');
  if (savedMode === 'dark') {
    document.body.classList.add('dark-mode');
  } else {
    document.body.classList.add('light-mode');
  }
}

function toggleDarkMode() {
  document.body.classList.toggle('dark-mode');
  document.body.classList.toggle('light-mode');

  const mode = document.body.classList.contains('dark-mode') ? 'dark' : 'light';
  localStorage.setItem('theme', mode);
}

document.addEventListener('DOMContentLoaded', () => {
  applySavedMode();

  const toggleBtn = document.getElementById('darkModeToggle');
  if (toggleBtn) {
    toggleBtn.addEventListener('click', toggleDarkMode);
  }
});