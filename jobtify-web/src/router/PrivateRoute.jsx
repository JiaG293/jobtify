import { Navigate } from "react-router-dom";
import { useState, useEffect } from "react";
import Cookies from "js-cookie";
import { toast } from "react-toastify";
import api from "../api/api";

const PrivateRoute = ({ children }) => {
  const [isAuth, setIsAuth] = useState(false);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const checkAuthentication = async () => {
      const token = Cookies.get('token');
      
      if (!token) {
        setIsAuth(false);
        setIsLoading(false);
        return;
      }

      try {
        const response = await api.post("/v1/identity/auth/introspect", { 
          token: token 
        });

        if (response.data?.result?.valid) {
          setIsAuth(true);
        } else {
          Cookies.remove('token');
          setIsAuth(false);
          toast.error("Phiên đăng nhập hết hạn");
        }
      } catch (error) {
        Cookies.remove('token');
        setIsAuth(false);
        toast.error("Lỗi xác thực");
      } finally {
        setIsLoading(false);
      }
    };

    checkAuthentication();
  }, []);

  if (isLoading) {
    return <div>Đang xác thực...</div>;
  }

  return isAuth ? children : <Navigate to="/login" replace />;
};

export default PrivateRoute;