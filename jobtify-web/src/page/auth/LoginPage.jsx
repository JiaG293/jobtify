import React, { useRef, useState } from "react";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useAuthStore } from "../../store/authUser";
import { useNavigate } from "react-router-dom";
import HomePage from "../home/HomePage";

const LoginPage = () => {
  const navigate = useNavigate();
  const [credentials, setCredentials] = useState({
    username: "giau",
    password: "123",
  });
  console.log("info input", credentials)

  const [showPassword, setShowPassword] = useState(false);
  const { login, isLoggingIn } = useAuthStore();

  const handleChangeInput = (e) => {
    const { name, value } = e.target;
    setCredentials({
      ...credentials,
      [name]: value,
    });
  };

  const togglePasswordVisibility = () => {
    setShowPassword((show) => !show);
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      login({
        username: credentials.username,
        password: credentials.password,
      });

      setTimeout(() => {
        navigate('/');
      }, 2000);
    } catch (error) {
      toast.error("Đăng nhập thất bại");
    }
  };


  return (
    <div
      style={{
        maxWidth: "50ch",
        minWidth: "40ch",
        margin: "auto",
        padding: "20px",
        border: "1px solid #ddd",
        borderRadius: "8px",
        boxShadow: "0 2px 4px rgba(0,0,0,0.1)",
        textAlign: "center",
      }}
    >
      <h3 className="text-3xl font-bold">Đăng nhập</h3>

      <form
        onSubmit={handleLogin}
        style={{
          display: "flex",
          flexDirection: "column",
        }}
      >

        <input
          name="username"
          type="text"
          placeholder="Tài khoản"
          value={credentials.username}
          onChange={handleChangeInput}
          className="bg-gray-light rounded-xl"
          style={{
            margin: "8px 0",
            padding: "10px",
            width: "100%",
            boxSizing: "border-box",
          }}
        />

        <div style={{ position: "relative", margin: "8px 0" }}>
          <input
            name="password"
            id="password-input"
            type={showPassword ? "text" : "password"}
            placeholder="Mật khẩu"
            value={credentials.password}
            onChange={handleChangeInput}
            className="bg-gray-light rounded-xl"
            style={{
              margin: "8px 0",
              padding: "10px",
              width: "100%",
              boxSizing: "border-box",
            }}
          />
          <button
            type="button"
            onClick={togglePasswordVisibility}
            style={{
              position: "absolute",
              right: "10px",
              top: "50%",
              transform: "translateY(-50%)",
              background: "none",
              border: "none",
              cursor: "pointer",
              color: "#555",
            }}
          >
            {showPassword ? "Ẩn" : "Hiện"}
          </button>
        </div>

        <div>
          <button
            type="submit"
            style={{
              margin: "10px 0",
              padding: "10px",
              width: "100%",
              backgroundColor: isLoggingIn ? "#aaa" : "#4caf50",
              color: "white",
              border: "none",
              borderRadius: "4px",
              cursor: isLoggingIn ? "not-allowed" : "pointer",
            }}
            disabled={isLoggingIn}
          >
            {isLoggingIn ? "Đang đăng nhập..." : "Đăng nhập"}
          </button>

          <a
            href="/singup"
            style={{
              margin: "10px 0",
              padding: "10px",
              display: "inline-block",
              textDecoration: "none",
              backgroundColor: "#2196F3",
              color: "white",
              borderRadius: "4px",
            }}
          >
            Đăng ký
          </a>
        </div>
      </form>
    </div>
  );
};

export default LoginPage;
