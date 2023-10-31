document.addEventListener('DOMContentLoaded', function () {
  const searchIcon = document.querySelector('.example-icon');
  const searchInput = document.querySelector('.search-input');

  searchIcon.addEventListener('click', function () {
    if (searchInput.style.display === 'none' || searchInput.style.display === '') {
      searchInput.style.display = 'block';
    } else {
      searchInput.style.display = 'none';
    }
  });
});
