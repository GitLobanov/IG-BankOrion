
    document.addEventListener("DOMContentLoaded", function() {
    const cardSelect = document.getElementById("cards");
    const cardInfoText = document.getElementById("card-info-text");

    cardSelect.addEventListener("change", function() {
    // Get the selected option value
    const selectedOptionValue = cardSelect.value;

    // Update the card-info-text with the selected card's amountMoney
    if (selectedOptionValue) {
    cardInfoText.textContent = "" + selectedOptionValue;
} else {
    cardInfoText.textContent = "Select a card to see the details.";
}
});
});
