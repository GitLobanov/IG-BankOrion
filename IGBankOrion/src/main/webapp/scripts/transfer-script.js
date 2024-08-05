document.getElementById('transfer-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const recipientName = document.getElementById('recipient-name').value;
    const cardNumber = document.getElementById('card-number').value;
    const transferAmount = document.getElementById('transfer-amount').value;

    // Simple validation
    if (recipientName && cardNumber.length === 16 && transferAmount > 0) {
        document.getElementById('message').textContent = `Successfully transferred $${transferAmount} to ${recipientName}.`;
    } else {
        document.getElementById('message').textContent = 'Please enter valid details.';
        document.getElementById('message').style.color = 'red';
    }
});
