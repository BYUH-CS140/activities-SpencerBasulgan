window.addEventListener("DOMContentLoaded", () => {
  const header = document.getElementById("mainHeader");

  window.addEventListener("scroll", () => {
    if (window.scrollY > 50) {
      header.style.opacity = "0.5";
    } else {
      header.style.opacity = "1";
    }
  });
});