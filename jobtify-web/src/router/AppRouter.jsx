import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import PrivateRoute from "./PrivateRoute";
import LoginPage from "../page/auth/LoginPage";
import HomePage from "../page/home/HomePage";
import PageNotFound from "../page/PageNotFound";
import RegisterPage from "../page/auth/RegisterPage";
import SkillPage from "../page/admin/SkillPage";
import JobSuggest from "../page/suggest/JobSuggestPage";

function AppRouter() {
  return (
    <Router>
      <Routes>
        <Route index element={<HomePage />} />
        <Route path="/signin" element={<LoginPage />} />
        <Route path="/signup" element={<RegisterPage />} />
        <Route path="/job-suggest" element={<JobSuggest />} />
        <Route path="*" element={<PageNotFound />} />


        {/* Private */}
        <Route
          path="/skills"
          element={
            <PrivateRoute>
              <SkillPage />
            </PrivateRoute>
          }
        />
      </Routes>
    </Router>
  );
}

export default AppRouter;
