function searchPapers() {
  const searchInput = document.getElementById('search').value.toLowerCase();
  const pdfLinks = document.querySelectorAll('.pdf-list a');
  pdfLinks.forEach(link => {
    const text = link.textContent.toLowerCase();
    if (text.includes(searchInput)) {
      link.style.display = 'block';
    } else {
      link.style.display = 'none';
    }
  });
}
