import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
import Cookies from "js-cookie";

const Header = () => {
    const [isMobileMenuOpen, setMobileMenuOpen] = useState(false);
    const [isLoggedIn, setIsLoggedIn] = useState(false);


    const toggleMobileMenu = () => {
        setMobileMenuOpen((prev) => !prev);
    };

    useEffect(() => {
        const token = Cookies.get("token");
        if (token) {
            setIsLoggedIn(true);
        } else {
            setIsLoggedIn(false);
        }
    }, []);



    return (
        <header className="bg-gray-light text-white shadow-md fixed top-0 left-0 right-0 z-50">
            <div className="container mx-auto flex items-center justify-between py-4 px-6">
                <div className="text-2xl font-bold">
                    <Link to="/" className="hover:text-gray-200">
                        Jobitfy
                    </Link>
                </div>

                <button
                    className="md:hidden block text-white focus:outline-none"
                    onClick={toggleMobileMenu}
                >
                    <svg
                        className="w-6 h-6"
                        fill="none"
                        stroke="currentColor"
                        viewBox="0 0 24 24"
                    >
                        <path
                            strokeLinecap="round"
                            strokeLinejoin="round"
                            strokeWidth="2"
                            d="M4 6h16M4 12h16M4 18h16"
                        ></path>
                    </svg>
                </button>

                <nav className="hidden md:flex space-x-8">
                    <Link to="/job-suggest" className="hover:text-gray-200">
                        Đề xuất việc làm
                    </Link>
                    <Link to="/company" className="hover:text-gray-200">
                        Dành cho công ty
                    </Link>
                    <Link to="/candidate" className="hover:text-gray-200">
                        Dành cho cá nhân
                    </Link>
                    <Link to="/skills" className="hover:text-gray-200">
                        skill admin
                    </Link>
                </nav>

                <div className="hidden md:flex space-x-4">
                    {isLoggedIn ? (
                        <Link
                            to="/profile"
                            className="px-4 py-2 bg-gray-100 text-blue-500 rounded hover:bg-gray-200"
                        >
                            Hồ sơ
                        </Link>
                    ) : (
                        <>
                            <Link
                                to="/signin"
                                className="px-4 py-2 bg-gray-100 text-blue-500 rounded hover:bg-gray-200"
                            >
                                Đăng nhập
                            </Link>
                            <Link
                                to="/signup"
                                className="px-4 py-2 bg-white text-blue-500 border border-blue-500 rounded hover:bg-blue-600 hover:text-white"
                            >
                                Đăng ký
                            </Link>
                        </>
                    )}
                </div>
            </div>

            {isMobileMenuOpen && (
                <div className="md:hidden bg-blue-500 text-white py-4 px-6 space-y-2">
                    <Link
                        to="/job-suggest"
                        className="block hover:text-gray-200"
                        onClick={() => setMobileMenuOpen(false)}
                    >
                         Đề xuất việc làm
                    </Link>
                    <Link
                        to="/company"
                        className="block hover:text-gray-200"
                        onClick={() => setMobileMenuOpen(false)}
                    >
                        Dành cho công ty
                    </Link>
                    <Link
                        to="/candidate"
                        className="block hover:text-gray-200"
                        onClick={() => setMobileMenuOpen(false)}
                    >
                        Dành cho cá nhân
                    </Link>
                    <Link
                        to="/skills"
                        className="block hover:text-gray-200"
                        onClick={() => setMobileMenuOpen(false)}
                    >
                        skill admin
                    </Link>
                    {isLoggedIn ? (
                        <Link
                            to="/profile"
                            className="block px-3 py-2 bg-gray-100 text-blue-500 rounded hover:bg-gray-200"
                            onClick={() => setMobileMenuOpen(false)}
                        >
                            Hồ sơ
                        </Link>
                    ) : (
                        <>
                            <Link
                                to="/signin"
                                className="block px-3 py-2 bg-gray-100 text-blue-500 rounded hover:bg-gray-200"
                                onClick={() => setMobileMenuOpen(false)}
                            >
                                Đăng nhập
                            </Link>
                            <Link
                                to="/signup"
                                className="block px-3 py-2 bg-white text-blue-500 border border-blue-500 rounded hover:bg-blue-600 hover:text-white"
                                onClick={() => setMobileMenuOpen(false)}
                            >
                                Đăng ký
                            </Link>
                        </>
                    )}
                </div>
            )}
        </header>
    );
};

export default Header;
