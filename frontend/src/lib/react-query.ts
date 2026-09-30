import { QueryClient, type DefaultOptions } from '@tanstack/react-query';

const queryConfig: DefaultOptions = {
  queries: {
    // 5 minutes stale time: prevent redundant network calls on components remounts
    staleTime: 1000 * 60 * 5,
    // Keep unused data in garbage collection for 15 minutes
    gcTime: 1000 * 60 * 15,
    // Refetch when the user refocuses the window/tab
    refetchOnWindowFocus: true,
    // Disable aggressive refetching on components remount if data isn't stale
    refetchOnMount: true,
    // Retry failed requests once before throwing an error
    retry: 1,
  },
  mutations: {
    // Global error handler for mutations (e.g., global toast trigger)
    onError: (error) => {
      console.error('[Global Mutation Error]:', error.message);
    },
  },
};

export const queryClient = new QueryClient({
  defaultOptions: queryConfig,
});