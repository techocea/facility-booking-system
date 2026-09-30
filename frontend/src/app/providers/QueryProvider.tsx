import React from 'react';
import { QueryClientProvider } from '@tanstack/react-query';
// import { ReactQueryDevtools } from '@tanstack/react-query-devtools';
import { queryClient } from '@/lib/react-query.ts';

interface QueryProviderProps {
  children: React.ReactNode;
}

export const QueryProvider: React.FC<QueryProviderProps> = ({ children }) => {
  return (
    <QueryClientProvider client={queryClient}>
      {children}
      {/* DevTools automatically loaded in development builds */}
      {/*{import.meta.env.DEV && (*/}
      {/*  <ReactQueryDevtools initialIsOpen={false} buttonPosition="bottom-right" />*/}
      {/*)}*/}
    </QueryClientProvider>
  );
};