import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { ToastContainer } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import { Fancybox } from "@fancyapps/ui";
import "@fancyapps/ui/dist/fancybox/fancybox.css";

createRoot(document.getElementById('root')).render(
  // <StrictMode>
  <>
    <ToastContainer />
    <App />
  </>
  // </StrictMode>,
)
