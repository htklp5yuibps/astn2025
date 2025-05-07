window.onload = () => {
    const pageContentData = document.querySelector(".page-content-data");

    const request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8080/astn2025/users');

    request.onload = () => {
        pageContentData.textContent = request.responseText;
    };

    request.send();
};