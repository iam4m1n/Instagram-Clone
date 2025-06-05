// src/layout/MainLayout.jsx

import React from "react";
import { Outlet } from "react-router-dom";
import Navbar from "../components/Header/Navbar";
import LargeNav from "../components/Header/LargeNav";

const MainLayout = () => {
  return (
    <div className="min-h-screen bg-black text-white">
      <Navbar />
      <div className="flex">
        <aside className="w-64 bg-gray-900 text-white min-h-screen p-4">
          <LargeNav />
        </aside>
        <main className="flex-1 bg-gray-950 text-white p-4">
          <Outlet />
        </main>
      </div>
    </div>
  );
};

export default MainLayout;