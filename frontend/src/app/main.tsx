import React from 'react';
import ReactDOM from 'react-dom/client';

import "@/styles/index.css"
import App from "./App.tsx"

import '@/config/env.ts';

const rootElement = document.getElementById('root');
if (!rootElement) {
  throw new Error('Failed to find the root element');
}

ReactDOM.createRoot(rootElement).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
