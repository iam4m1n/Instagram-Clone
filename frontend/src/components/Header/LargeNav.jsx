import React from "react";
import { NavLink } from "react-router-dom";

import SearchLogo from "../../assets/icons/nav_icons/search.png";
import ExploreLogo from "../../assets/icons/nav_icons/explore.png";
import ReelsLogo from "../../assets/icons/nav_icons/reels.png";
import MessagesLogo from "../../assets/icons/nav_icons/messages.png";
import NotificationsLogo from "../../assets/icons/nav_icons/notifications.png";
import CreateLogo from "../../assets/icons/nav_icons/create.png";

const sidebarItems = [
  { name: "Search", link: "/search", icon: SearchLogo },
  { name: "Explore", link: "/explore", icon: ExploreLogo },
  { name: "Reels", link: "/reels", icon: ReelsLogo },
  { name: "Messages", link: "/messages", icon: MessagesLogo },
  { name: "Notifications", link: "/notifications", icon: NotificationsLogo },
  { name: "Create", link: "/create", icon: CreateLogo },
];

const LargeNav = () => {
  return (
    <nav className="flex flex-col gap-2 bg-black py-4 px-2 rounded-xl">
      {sidebarItems.map((item) => (
        <NavLink
          to={item.link}
          key={item.name}
          className={({ isActive }) =>
            `flex items-center gap-3 px-4 py-2 rounded-lg transition
            ${
              isActive
                ? "bg-neutral-800 text-white font-semibold"
                : "text-gray-400 hover:bg-neutral-900"
            }`
          }
        >
          <img src={item.icon} alt={item.name} className="w-6 h-6" />
          <span className="text-sm">{item.name}</span>
        </NavLink>
      ))}
    </nav>
  );
};

export default LargeNav;
