'use strict';

let usernamePage = document.querySelector('#username-page');
let chatPage = document.querySelector('#chat-page');
let usernameForm = document.querySelector('#usernameForm');
let messageForm = document.querySelector('#messageForm');
let messageInput = document.querySelector('#message');
let messageArea = document.querySelector('#messageArea');
let connectingElement = document.querySelector('.connecting');

let stompClient = null;
let username = null;

let colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

//////////////////Username Store//////////////////////

//window.addEventListener("load", checkStoredUsername);

//document.addEventListener("DOMContentLoaded", () => checkStoredUsername());


function checkStoredUsername() {
    let storedUsername = localStorage.getItem("chatUsername");

    if (storedUsername) {
        // If username is already stored, use it directly
        username = storedUsername;

        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        let socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
    } else {
        // If not stored, show the username input page
        usernamePage.classList.remove('hidden');
        chatPage.classList.add('hidden');
    }
}
/////////////////////////////////////////////////////

function connect(event) {
    username = document.querySelector('#name').value.trim();
    localStorage.setItem("chatUsername", username);

    if(username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        let socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}


function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);

    // Subscribe to online user count
            stompClient.subscribe('/topic/onlineCount', onOnlineCountReceived);
            stompClient.subscribe('/topic/onlineUsers', onOnlineUserNameReceived);

    // Tell your username to the server
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )

    connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}

function sendMessage(event) {
    let messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        let chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}


function onMessageReceived(payload) {
    let message = JSON.parse(payload.body);

    let messageElement = document.createElement('li');

    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {
        messageElement.classList.add('chat-message');

        let avatarElement = document.createElement('i');
        let avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

        let usernameElement = document.createElement('span');
        let usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }

    let textElement = document.createElement('p');
    let messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}


function getAvatarColor(messageSender) {
    let hash = 0;
    for (let i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    let index = Math.abs(hash % colors.length);
    return colors[index];
}

//---------------------------------------------------------------------------

function onOnlineCountReceived(payload) {
    const onlineCount = payload.body; // backend sends just the number
    document.querySelector("#onlineCount").textContent = "Online Users: " + onlineCount;
    //console.log(onlineCount);
    }

function onOnlineUserNameReceived(payload){
    const users = JSON.parse(payload.body);
    const container = document.querySelector("#onlineUsers");
    container.innerHTML = "";
    users.forEach(user => {
        const li = document.createElement("li");
        li.textContent = user;
        container.appendChild(li);
    });}

///-------------------------------------------------------------------------
// -----------------------Chat History Handle ------------------------------

async function loadChatHistory() {
    try {
        const response = await fetch('/chat/history');
        const chats = await response.json();
        displayChatHistory(chats);
    } catch (error) {
        console.error('Error fetching chat history:', error);
    }
}
function displayChatHistory(chats) {
    chats.slice().reverse().forEach(chat => {
        onMessageReceived({ body: JSON.stringify(chat) });
    });
}

//function displayChatHistory(chats) {
//    const chatBox = document.getElementById('messageArea'); // your chat container
//    if (!chatBox) return;
//
//    chats.forEach(chat => {
//        const msg = document.createElement('div');
//
//        if (chat.type === 'CHAT') {
//            msg.textContent = `${chat.sender}: ${chat.content}`;
//        } else if (chat.type === 'JOIN') {
//            msg.textContent = `${chat.sender} joined the chat`;
//        }
//
//        chatBox.appendChild(msg);
//    });
//}

// Load chat history when the page loads
//window.addEventListener('DOMContentLoaded', loadChatHistory);


document.addEventListener("DOMContentLoaded", () => {
  loadChatHistory();
  checkStoredUsername();
});


//-------------------------------------------------------------------------------------

messageInput.addEventListener('keydown', function (event) {
  if (event.key === 'Enter') {
    event.preventDefault(); // stop form from reloading page

    // trigger form submission
    messageForm.dispatchEvent(new Event('submit', { bubbles: true, cancelable: true }));
    console.log("hiiihihihihisgfdadasgfddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
    // clear input
    messageInput.value = '';
  }
});


//---------------------------------------------------------------------------

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', sendMessage, true)
