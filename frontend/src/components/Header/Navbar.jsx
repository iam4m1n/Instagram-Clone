// src/components/Header/Navbar.jsx

import React from "react";
import LargeNav from "./LargeNav";

const Navbar = () => {
  return (
    <header className="w-full bg-gray-900 text-white py-4 px-6">
      <div className="flex items-center justify-between">
        <h1 className="text-xl font-bold">Instagram Clone</h1>
        <LargeNav />
      </div>
    </header>
  );
};

export default Navbar;