const images = [
  "./images/AWScert.png",
  "./images/highdiploma.png",
  "./images/pathway.png",
  "./images/apcc.png"
];

let currentIndex = 0;
const photo = document.getElementById("photo");

function showPhoto(index) {
  photo.src = images[index];
}

function nextPhoto() {
  currentIndex = (currentIndex + 1) % images.length;
  showPhoto(currentIndex);
}

function prevPhoto() {
  currentIndex = (currentIndex - 1 + images.length) % images.length;
  showPhoto(currentIndex);
}

// Optional: keyboard controls
document.addEventListener("keydown", (event) => {
  if (event.key === "ArrowRight") {
    nextPhoto();
  } else if (event.key === "ArrowLeft") {
    prevPhoto();
  }
});