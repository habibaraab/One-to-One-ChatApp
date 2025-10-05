db = db.getSiblingDB('chat_app');

db.createUser({
    user: "bia",
    pwd: "bia",
    roles: [
        { role: "readWrite", db: "chat_app" }
    ]
});