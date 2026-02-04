// Firebase Configuration
// YOU MUST REPLACE THESE VALUES WITH YOUR OWN FROM THE FIREBASE CONSOLE
// 1. Go to https://console.firebase.google.com/
// 2. Create a new project
// 3. Add a Web App
// 4. Copy the "firebaseConfig" object here:

const firebaseConfig = {
  apiKey: "AIzaSyBswrE8CzfRKZ9Jm8G2x457ARETBxlmKKo",
  authDomain: "authnotecodium.firebaseapp.com",
  projectId: "authnotecodium",
  storageBucket: "authnotecodium.firebasestorage.app",
  messagingSenderId: "293330618423",
  appId: "1:293330618423:web:989e9cd1605cc7e4ae17b2",
  measurementId: "G-3T2BR8XR7H"
};


// Initialize Firebase
import { initializeApp } from "https://www.gstatic.com/firebasejs/10.7.1/firebase-app.js";
import { getAuth, GithubAuthProvider, signInWithPopup, onAuthStateChanged, signOut }
    from "https://www.gstatic.com/firebasejs/10.7.1/firebase-auth.js";

const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const provider = new GithubAuthProvider();

export { auth, provider, signInWithPopup, signOut, onAuthStateChanged };
