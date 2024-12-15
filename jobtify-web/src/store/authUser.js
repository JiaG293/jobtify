import { jwtDecode } from "jwt-decode";
import api from "../api/api";
import { create } from "zustand";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Cookies from "js-cookie";


export const useAuthStore = create((set) => ({
  user: null,
  isSigningUp: false,
  isLoggingOut: false,
  isLoggingIn: false,
  isAuthenticate: false,
  register: async (credentials) => {
    set({ isSigningUp: true });
    try {
      const response = await api.post("/v1/identity/users/register", credentials);
      set({ user: response.data.user, isSigningUp: false });
      toast.success("Đăng ký thành công");
    } catch (error) {
      toast.error(error.response.data.message || "Lỗi đăng ký");
      set({ isSigningUp: false, user: null });
    }
  },
  login: async (credentials) => {
    set({ isLoggingIn: true });
    try {
      const response = await api.post("/v1/identity/auth/login", credentials);
      Cookies.set("token", response.data.result.token)
      toast.success("Đăng nhập thành công, đang chuyển về trang chủ");
      set({ user: jwtDecode(response.data.result.token), isLoggingIn: false, isAuthenticate: true });
    } catch (error) {
      set({ isLoggingIn: false, user: null });
      toast.error(error.response?.data?.message || error.message || "Đang nhập thất bại");
    }
  },
  logout: async () => {
    set({ isLoggingOut: true });
    try {
      await api.post("/v1/identity/auth/logout");
      set({ user: null, isLoggingOut: false, isAuthenticate: false });
      toast.success("Logged out successfully");
    } catch (error) {
      set({ isLoggingOut: false, isAuthenticate: true });
      toast.error(error.response.data.message || "Logout failed");
    }
  },
  authCheck: async () => {
    try {
      const token = Cookies.get('token');
      if (token == null) {
        set({ isAuthenticate: false })
      }
      console.log("token la: ", token)
      const response = await api.post("/v1/identity/auth/introspect", {
        token: token
      });
      console.log("valid", response.data.result)
      if (response.data.result.valid) {
        set({ user: jwtDecode(response.data.result.token), isLoggingIn: false, isAuthenticate: true });
        toast.success("Đã xác thực");
      } else throw new toast.error("Xác thực thất bại về trang đăng nhập")
    } catch (error) {
      set({ isAuthenticate: false, user: null });
      // toast.error(error.response.data.message || "An error occurred");
    }
  },
  
}));