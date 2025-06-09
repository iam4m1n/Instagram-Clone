import React from "react";

const Stories = () => {
  return (
    <div className="flex items-center space-x-4 overflow-x-auto p-3 bg-gray-900 rounded-lg border border-gray-700 scrollbar-thin scrollbar-thumb-gray-600">
      {storiesData.map((story) => (
        <div
          key={story.id}
          className="flex flex-col items-center justify-center cursor-pointer"
        >
          <div className="relative">
            <div className="w-16 h-16 rounded-full border-2 border-pink-500 p-1">
              <img
                src={story.img}
                alt={story.username}
                className="w-full h-full rounded-full object-cover"
              />
            </div>
            <div className="absolute bottom-0 right-0 bg-blue-500 w-4 h-4 rounded-full border-2 border-gray-900"></div>
          </div>
          <span className="text-xs text-gray-300 mt-1">{story.username}</span>
        </div>
      ))}
    </div>
  );
};

export default Stories;